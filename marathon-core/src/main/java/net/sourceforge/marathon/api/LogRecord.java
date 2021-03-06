/*******************************************************************************
 * Copyright 2016 Jalian Systems Pvt. Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package net.sourceforge.marathon.api;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;

public class LogRecord implements Serializable {

    public static final Logger LOGGER = Logger.getLogger(LogRecord.class.getName());

    private static final long serialVersionUID = 1L;

    private final String message;
    private final String description;
    private final String module;
    private final Date date;
    private final int type;

    public LogRecord(int type, String message, String description, String module, Date date) {
        this.type = type;
        this.message = message;
        this.description = description;
        this.module = module;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public String getModule() {
        return module;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public int getType() {
        return type;
    }
}
