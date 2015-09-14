[![Build Status](https://travis-ci.org/Fewlaps/quitnow-email-suggester.svg?branch=master)](https://travis-ci.org/Fewlaps/quitnow-email-suggester.svg?branch=master)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-quitnow--email--suggester-green.svg?style=flat)](https://android-arsenal.com/details/1/2465)

# [QuitNow!](http://quitnowapp.com)'s e-mail suggester
People don't write e-mail addresses without misspelling from time to time. @gmial.con addresses are too common... And we need to put a stop to it!

QuitNow!'s server is doing the usual e-mail validaton during user creation time. We're doing it like everyone does: sending an e-mail to the user, and waiting for the user to click a link. The only validation we do is to check the e-mail with usual regex... but we need to go a little beyond that. Looking for *.CON* and suggesting *.COM* is something that would make the world a better place!

By the way, we recently learnt a lot about TDD (Test-Driven Development) at some [Karumi](https://github.com/Karumi) masterclasses, so we decided to go on with TDD. The only way to master something is by doing. 

Incidentally, it will be useful if we improve our e-mail validation (and, hopefully, yours).

If you want to see what suggestions and validations are being done, <a href="https://github.com/Fewlaps/quitnow-email-suggester/tree/master/src/test/java/com/fewlaps/quitnowemailsuggester">check the actual tests</a>. It's an easy way for us to document the behaviour, and it's the tried-and-true list for you to know what's exactly happening here.

Don't hesitate to add some issues and good (failing) tests! And, of course, if you want to contribute to the project with new features, it will be really appreciated :·)

Download
--------

* Get <a href="https://github.com/Fewlaps/quitnow-email-suggester/releases/download/v1.3.2/quitnow-email-suggester-1.3.2.jar">the last .jar</a> 

* Grab via Gradle:
```groovy
repositories { jcenter() } }
    
compile 'com.fewlaps.quitnowemailsuggester:quitnow-email-suggester:1.3.2'
```
* Grab via Maven:
```xml
<repository>
  <id>jcenter</id>
  <url>http://jcenter.bintray.com</url>
</repository>

<dependency>
    <groupId>com.fewlaps.quitnowemailsuggester</groupId>
    <artifactId>quitnow-email-suggester</artifactId>
    <version>1.3.2</version>
</dependency>
```

Use the API
-----------

There's also an open source project that works with this algorithm. Check it and star it!

[QuitNow!'s e-mail suggester API](https://github.com/Fewlaps/quitnow-email-suggester-api)



## LICENSE ##

The MIT License (MIT)

Copyright (c) 2015 Fewlaps

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
