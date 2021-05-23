[![Build Status](https://travis-ci.org/Fewlaps/quitnow-email-suggester.svg?branch=master)](https://travis-ci.org/Fewlaps/quitnow-email-suggester)
[![Coverage Status](https://coveralls.io/repos/Fewlaps/quitnow-email-suggester/badge.svg?branch=master&service=github)](https://coveralls.io/github/Fewlaps/quitnow-email-suggester?branch=master)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-quitnow--email--suggester-green.svg?style=flat)](https://android-arsenal.com/details/1/2465)
[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/Fewlaps/quitnow-email-suggester?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

# [QuitNow!](http://quitnowapp.com)'s e-mail suggester
People don't write e-mail addresses without misspelling from time to time. @gmial.con addresses are too common... And we need to put a stop to it!

QuitNow!'s server is doing the usual e-mail validaton during user creation time. We're doing it like everyone does: sending an e-mail to the user, and waiting for the user to click a link. The only validation we do is to check the e-mail with usual regex... but we need to go a little beyond that. Looking for *.con* and suggesting *.com* is something that would make the world a better place!

By the way, we recently learnt a lot about TDD (Test-Driven Development) at some [Karumi](https://github.com/Karumi) masterclasses, so we decided to go on with TDD. The only way to master something is by doing. Incidentally, it will be useful if we improve our e-mail validation (and, hopefully, yours).

If you want to see what suggestions and validations are being done, <a href="https://github.com/Fewlaps/quitnow-email-suggester/tree/master/src/test/java/com/fewlaps/quitnowemailsuggester">check the actual tests</a>. It's an easy way for us to document the behaviour, and it's the tried-and-true list for you to know what's exactly happening here.

## How it works?

### Email suggester
```java
// Hello! Let me show the magic of this library: the email suggester
EmailSuggester suggester = new EmailSuggester();

// It is a little thing that has an algorithm to fix human typos.
// Let's say your user mistyped his email address:
String badEmail = "roc@gmial.com";
String goodEmail = suggester.getSuggestedEmail(badEmail);
// goodEmail will contain the fixed email address. WOW!
// And there are tons of email fixes. They're listed at https://goo.gl/IF52EV
// In addition, it will never suggest a bad domain. All the suggestions are written one by one,
// based on the QuitNow! users and their e-mail bounces. If it doesn't know nothing
// better than the input, it will return the same email.
```

### Email validator & Android account email cleaner
```java
// Well! Something else? Yes: this library hosts some more email related things
EmailValidator validator = new EmailValidator();
validator.hasGoodSyntax(goodEmail); //Does it match the email regex?
validator.hasValidTld(goodEmail); //Has it a valid TLD?
validator.isAlias(goodEmail); //Is it an alias?
validator.isDisposable(goodEmail); //Is it listed as a disposable domain?

// To finish up: if you work with Android, you'll find roc@fewlaps.com:WhatEVER emails
// If you want to clean them, here it goes:
AndroidAccountEmailCleaner cleaner = new AndroidAccountEmailCleaner();
String androidAccountEmail = "roc@fewlaps.com:WhatEVER";
String cleanedEmail = cleaner.cleanEmail(androidAccountEmail);
// cleanedEmail will contain roc@fewlaps.com
```


#### *.hasValidTld()* and *.isDisposable()* under the hood
- *.hasValidTld()* is getting data from this public repo: https://github.com/publicsuffix/list
- *.isDisposable()* is checking the domain against this another one: https://github.com/ivolo/disposable-email-domains

The files needs to be attached to the project cause they're parsed locally.

So, before starting, initalise git submodules:

```
git submodule update --init --recursive
```

## Download

* Get <a href="https://github.com/Fewlaps/quitnow-email-suggester/releases/download/v2.0.0/quitnow-email-suggester-2.0.0.jar">the latest .jar</a> 

* Grab via Gradle:
```groovy
repositories { jcenter() }
    
compile 'com.fewlaps.quitnowemailsuggester:quitnow-email-suggester:2.0.0'
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
    <version>2.0.0</version>
</dependency>
```

## LICENSE

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
