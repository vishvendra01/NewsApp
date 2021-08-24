<h1>News App</h1>

News App is a showcase app for [News Api](https://newsapi.org/) on Android, built using Kotlin.

## Architecture and Tech-stack

* Built on MVVM architecture pattern
* Uses [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/), specifically ViewModel, LiveData and Room.
* Has a clean, gorgeous user interface with pretty animations, built using Android Transitions framework, and [Material Components for Android](https://github.com/material-components/material-components-android)
* Uses [Coroutines](https://kotlinlang.org/docs/coroutines-guide.html) and [Flow](https://kotlinlang.org/docs/flow.html) for network calls, transformations, and database observation.
* It's uses [Room](https://developer.android.com/topic/libraries/architecture/room) for managing a local SQLite database for offline caching.
* Uses [Retrofit](https://square.github.io/retrofit/) for making API calls.
* Uses [Glide](https://github.com/bumptech/glide) for image loading.

## Features
* Displays Top technology news headlines.
* Search for news (TODO)
* Works offline by caching data into a database.
* Supports dark mode.
* Pagination (TODO)