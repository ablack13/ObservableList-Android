<h1>ObservableList-Android</h1>
ObservableList support for Android is a small wrapper on a native List/ArrayList for support observe changes

<h3>Setup</h3>
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			maven { url "https://jitpack.io" }
		}
	}
	
Add the dependency

	dependencies {
	        compile 'com.github.scijoker:ObservableList-Android:2.0'
	}
	
<h3>How to use</h3>

1.Create ObservableList:

<b>ObservableList<ObjectType> list = new ObservableArrayList<>();</b> 


2.Add change listener:

<b>list.addOnChangeListener(new ObservableList.OnChangeListener<Integer>());</b>

<h3> Example</h3>
See example in <b> app</b> module

License
--------

    Copyright 2016 A.Prayzner

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

