/**
 * Tencent is pleased to support the open source community by making Tars available.
 *
 * Copyright (C) 2016 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.qq.tars.quickstart.server.testapp.impl;

import com.qq.tars.quickstart.server.testapp.PostServant;
import com.qq.tars.spring.annotation.TarsServant;

@TarsServant("PostObj")
public class PostServantImpl implements PostServant {

    @Override
    public String hello(int no, String name) {
        return String.format("hello no=%s, name=%s, time=%s", no, name, System.currentTimeMillis());
    }

    @Override
    // check if user exists, if exists return user json object, else return error
    public String getAuthorPost(int author) {
        // todo: create new data service obj and call its method
        
        // serialize a new post 
        StringBuilder sb = new StringBuilder("{Post:{");
        sb.append("pid:").append(0);
        sb.append(",title:").append("a new title");
        sb.append(",author:").append(author);
        sb.append(",content:").append("some new content");
        sb.append(",publish:").append("some publish date");
        sb.append("}}");

        return sb.toString();
    }
    
}
