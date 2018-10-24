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

package com.gm.plugin.extensions

import com.gm.plugin.utils.DimensExt
import org.gradle.api.Action

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 23/10/18.
 */
class ScreenExt {

    DimensExt dimensExt

    ScreenExt(){
        dimensExt = new DimensExt()
    }

    def dimens(Action<DimensExt> action){
        action.execute(this.dimensExt)
    }

    @Override
    String toString() {
        return "dimens = { $dimensExt };"
    }
}
