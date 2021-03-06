/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.executor.result;

import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Clinton Begin
 * ResultHandler 是对结果集映射后的对象进行管理包括，每映射完一个对象后就会把该对象交给 ResultHandler 进行管理。
 */
public class DefaultResultHandler implements ResultHandler<Object> {

  private final List<Object> list;

  public DefaultResultHandler() {
    list = new ArrayList<Object>();
  }

  @SuppressWarnings("unchecked")
  public DefaultResultHandler(ObjectFactory objectFactory) {
    list = objectFactory.create(List.class);
  }

  @Override
  public void handleResult(ResultContext<? extends Object> context) {
    list.add(context.getResultObject());
  }

  public List<Object> getResultList() {
    return list;
  }

}
