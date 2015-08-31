# [QuitNow!](http://quitnowapp.com)'s e-mail validator
People don't write e-mail addresses without misspelling from time to time. @gmial.con addresses are too common... And we need to put a stop to it!

QuitNow!'s server is doing the usual e-mail validaton during user creation time. We're doing it like everyone does: sending an e-mail to the user, and waiting for the user to click a link. The only validation we do is to check the e-mail with usual regex... but we need to go a little beyond that. Looking for *.CON* and suggesting *.COM* is something that would make the world a better place!

By the way, we recently learnt a lot about TDD (Test-Driven Development) at some [Karumi](https://github.com/Karumi) masterclasses, so we decided to go on with TDD. The only way to master something is by doing. 

Incidentally, it will be useful if we improve our e-mail validation (and, hopefully, yours).

If you want to see what suggestions and validations are being done, <a href="https://github.com/Fewlaps/quitnow-email-suggester/tree/master/src/test/java/com/fewlaps/quitnowemailsuggester">check the actual tests</a>. It's an easy way for us to document the behaviour, and it's the tried-and-true list for you to know what's exactly happening here.

Don't hesitate to add some issues and good (failing) tests! And, of course, if you want to contribute to the project with new features, it will be really appreciated :·)
