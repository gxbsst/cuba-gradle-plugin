/*
 * Copyright (c) 2008-2017 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.gradle.enhance;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BeanValidationMessageTransformer {

    public static final Pattern messagePattern = Pattern.compile("(\\{msg://)([\\p{L}\\w.]*})");

    public String transformAnnotationMessage(String messageValue, String packageName) {
        if (messagePattern.matcher(messageValue).matches()) {
            Matcher matcher = messagePattern.matcher(messageValue);
            if (matcher.find()) {
                return matcher.group(1) + packageName + "/" + matcher.group(2);
            }
        }
        return messageValue;
    }
}