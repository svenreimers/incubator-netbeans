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
package org.netbeans.modules.maven.j2ee.web;

import java.beans.PropertyChangeListener;
import java.util.Collection;
import org.netbeans.api.project.Project;
import org.netbeans.modules.maven.api.NbMavenProject;
import org.netbeans.modules.web.common.ui.api.CssPreprocessorsUI;
import org.netbeans.spi.project.ProjectServiceProvider;
import org.netbeans.spi.project.ui.ProjectProblemsProvider;

@ProjectServiceProvider(service = ProjectProblemsProvider.class, projectType = "org-netbeans-modules-maven/" + NbMavenProject.TYPE_WAR)
public class CssPreprocessorsProblemProvider implements ProjectProblemsProvider {

    private final ProjectProblemsProvider problemsProvider;


    public CssPreprocessorsProblemProvider(Project project) {
        problemsProvider = CssPreprocessorsUI.getDefault().createProjectProblemsProvider(project);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        problemsProvider.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        problemsProvider.removePropertyChangeListener(listener);
    }

    @Override
    public Collection<? extends ProjectProblem> getProblems() {
        return problemsProvider.getProblems();
    }

}
