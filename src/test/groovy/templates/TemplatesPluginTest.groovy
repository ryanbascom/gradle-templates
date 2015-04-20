/*
 * Copyright (c) 2011,2012 Eric Berry <elberry@tellurianring.com>
 * Copyright (c) 2013 Christopher J. Stehno <chris@stehno.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package templates
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class TemplatesPluginTest {

    @Test void 'apply'(){
        Project project = ProjectBuilder.builder().build()
        project.apply plugin: 'templates'

        assert project.tasks.exportAllTemplates

        assert project.tasks.getByName(ConnectorTemplatesPlugin.CREATE_CONNECTOR_TASK_NAME)
        assert project.tasks.getByName(ConnectorTemplatesPlugin.CONVERT_CONNECTOR_TASK_NAME)

        assert project.tasks.createGradlePlugin
        assert project.tasks.exportPluginTemplates
        assert project.tasks.initGradlePlugin

        assert project.tasks.createGroovyClass
        assert project.tasks.createGroovyProject
        assert project.tasks.exportGroovyTemplates
        assert project.tasks.initGroovyProject

        assert project.tasks.createJavaClass
        assert project.tasks.createJavaProject
        assert project.tasks.exportJavaTemplates
        assert project.tasks.initJavaProject

        assert project.tasks.createScalaClass
        assert project.tasks.createScalaObject
        assert project.tasks.createScalaProject
        assert project.tasks.exportScalaTemplates
        assert project.tasks.initScalaProject

        assert project.tasks.createWebappProject
        assert project.tasks.exportWebappTemplates
        assert project.tasks.initWebappProject
    }

}
