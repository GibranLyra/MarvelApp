# MarvelApp

## A demonstration of MVVM pattern using the trending libraries of the android world.
 
App is based on the [Google TODO MVVM pattern](https://github.com/android/architecture-samples/tree/dev-todo-mvvm-rxjava), this pattern was choosed to make the business logic easily testable.

### Some Notes

I created a exclusive module exclusively to demonstrate a way to let the service be totally decoupled from the app. That helps when the service is the same in multiple front ends.


## Tests
Made one unit test and one instrumented test to show how with this architecture we make things easier to test.

 - Unit tests under [test folder](https://github.com/GibranLyra/MarvelApp/tree/main/app/src/test/java/com/gibran/marvelapp)

 - Instrumentation test under [androidtests folder](https://github.com/GibranLyra/MarvelApp/tree/main/app/src/androidTest/java/com/gibran/marvelapp)


## Improvements I would make
 - Implement better theming support
 - Add more unitTests
 - add more instrumented tests
 - Add splash screen

## Used Libraries
- Kotlin
- [KotlinSerialization](https://github.com/Kotlin/kotlinx.serialization)
- [Retrofit](http://square.github.io/retrofit)
- [RxJava2](https://github.com/ReactiveX/RxJava)
- [Koin](https://insert-koin.io/)
- [Timber](https://github.com/JakeWharton/timber)
- [Glide](https://github.com/bumptech/glide)
- JUnit
- [Espresso](https://developer.android.com/training/testing/espresso/index.html)

License
==========

Copyright (c) GibranLyra 2018

GNU GENERAL PUBLIC LICENSE

Version 3, 29 June 2007

See LICENSE.md
