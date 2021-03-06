/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package retrofit;

import java.lang.reflect.Type;

public interface CallAdapter<T> {
  /**
   * Returns the value type that this adapter uses when converting the HTTP response body to a Java
   * object. For example, the response type for {@code Call<Repo>} is {@code Repo}. This type
   * is used to prepare the {@code call} passed to {@code #adapt}.
   *
   * <p>Note that this is typically not the same type as the {@code returnType} provided to
   * this call adapter's factory.
   */
  Type responseType();

  /**
   * Returns an instance of the {@code returnType}, the same type originally passed to {@link
   * Factory#get} used to create this instance.
   */
  Object adapt(Call<T> call);

  interface Factory {

    /**
     * Returns a call adapter for calls that return {@code returnType}, or null if this factory
     * doesn't adapt that type.
     */
    CallAdapter<?> get(Type returnType);
  }
}
