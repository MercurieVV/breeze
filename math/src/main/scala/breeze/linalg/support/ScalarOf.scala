/*
 *
 *  Copyright 2015 David Hall
 *
 *  Licensed under the Apache License, Version 2.0 (the "License")
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * /
 */

package breeze.linalg.support

/**
 * Marker trait indicating that S is the scalar of V. useful for wrangling type inference
 *
 * @author dlwh
 **/
sealed trait ScalarOf[@specialized V, @specialized S] {}

object ScalarOf {
  object DummyInstance extends ScalarOf[Any, Any]
  inline def dummy[@specialized V, @specialized S]: ScalarOf[V, S] = DummyInstance.asInstanceOf[ScalarOf[V, S]]

  implicit def scalarOfArray[T]: ScalarOf[Array[T], T] = dummy

}
