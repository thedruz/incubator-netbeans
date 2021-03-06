/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.mercurial.ui.annotate;

import javax.swing.text.JTextComponent;
import org.netbeans.modules.editor.errorstripe.privatespi.MarkProvider;
import org.netbeans.modules.editor.errorstripe.privatespi.MarkProviderCreator;

/**
 * ErrorStripe SPI entry point registered at layer.
 *
 * @author Maros Sandor
 */
public final class AnnotationMarkInstaller implements MarkProviderCreator {

    private static final Object PROVIDER_KEY = new Object();

    public MarkProvider createMarkProvider(JTextComponent pane) {
        AnnotationMarkProvider amp = new AnnotationMarkProvider();
        pane.putClientProperty(PROVIDER_KEY, amp);
        return amp;
    }
    
    public static AnnotationMarkProvider getMarkProvider(JTextComponent pane) {
        return (AnnotationMarkProvider) pane.getClientProperty(PROVIDER_KEY);
    }
}
