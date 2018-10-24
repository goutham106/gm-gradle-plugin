/*
 * Copyright (c) 2018, Gowtham Parimelazhagan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gm.plugin

import com.gm.plugin.extensions.ScreenExt
import com.gm.plugin.utils.DimensConvertHelper
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 23/10/18.
 */
class ScreenPlugin implements Plugin<Project> {

    private static final String EXTENSION_NAME = "screen"

    private designMap

    @Override
    void apply(Project target) {

        ScreenExt screenExt = target.extensions.create(EXTENSION_NAME,ScreenExt)
        designMap = new LinkedHashMap<String,String>()

        def dimensTask = target.task("dimensCovert"){
            group 'plugin'
            doLast{
                ScreenExt ext = target.extensions.getByName(EXTENSION_NAME) as ScreenExt
                new DimensConvertHelper(target, ext.dimensExt).createSwDimens()
            }
        }

        target.afterEvaluate {
            println(screenExt)
            if (screenExt.dimensExt.auto){
                new DimensConvertHelper(target, screenExt.dimensExt).createSwDimens()
                println(':plugin:dimensCovert')
            }
        }


    }
}

