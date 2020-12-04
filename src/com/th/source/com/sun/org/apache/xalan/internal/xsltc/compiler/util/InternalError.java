/*
 * Copyright (c) 2007, 2016, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * Copyright 2001-2004 The Apache Software Foundation.
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

/*
 * $Id: InternalError.java,v 1.0 2011-08-18 04:34:19 joehw Exp $
 */
package com.sun.org.apache.xalan.internal.xsltc.compiler.util;
/**
 * Marks a class of errors in which XSLTC has reached some incorrect internal
 * state from which it cannot recover.
 */
public class InternalError extends Error {
    /**
     * Construct an <code>InternalError</code> with the specified error message.
     * @param msg the error message
     */
    public InternalError(String msg) {
        super(msg);
    }
}
