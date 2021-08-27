<h1>News App</h1>

News App is a showcase app for [News API](https://newsapi.org/) on Android, built using Kotlin.

## Architecture and Tech-stack

* Built on MVVM architecture pattern
* Uses [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/), specifically ViewModel, LiveData and Room.
* Has a clean, gorgeous user interface with pretty animations, built using Android Transitions framework, and [Material Components for Android](https://github.com/material-components/material-components-android)
* Uses [Coroutines](https://kotlinlang.org/docs/coroutines-guide.html) and [Flow](https://kotlinlang.org/docs/flow.html) for network calls, transformations, and database observation.
* It's uses [Room](https://developer.android.com/topic/libraries/architecture/room) for managing a local SQLite database for offline caching.
* Uses [Retrofit](https://square.github.io/retrofit/) for making API calls.
* Uses [Glide](https://github.com/bumptech/glide) for image loading.
* Uses [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) Dependency injection.

## Features
* Displays Top technology news headlines.
* Works offline by caching data into a database.
* Supports dark mode.
* Pagination **(TODO)**
* Search for news **(TODO)**

## Build Instructions
To Run this app get an api key from [News API](https://newsapi.org/) and set that to `NEWS_API_KEY` in your `local.properties` file

## Screenshots
<img src="https://i.imgur.com/tb3EwMt.png" width="25%"></img>
<img src="https://i.imgur.com/xwS5r2D.png" width="25%"></img>