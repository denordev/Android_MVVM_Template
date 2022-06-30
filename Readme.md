Clean Architecture with MVVM are used in this template.

Libraries Used in template:

1. <a href="https://developer.android.com/guide/navigation/navigation-getting-started">Navigation Component with NavArgs </a>
2. <a href="https://developer.android.com/training/dependency-injection/dagger-basics">Dagger 2  </a>
3. <a href="https://developer.android.com/kotlin/coroutines">Kotlin Coroutines </a>
4. <a href="https://developer.android.com/topic/libraries/architecture/coroutines">Coroutines Lifecycle Scope </a>
5. <a href="https://developer.android.com/kotlin/ktx">Fragments KTX </a>
6. <a href="https://developer.android.com/training/data-storage/room">Room </a>
7. <a href="https://square.github.io/retrofit/">Retrofit 2</a>
8. <a href="https://github.com/square/moshi">Moshi </a>
9. <a href="https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor">OkHTTP3 Interceptor </a>
10.  <a href="https://github.com/google/gson">GSON </a>
11. <a href="https://github.com/orhanobut/logger">Orhanobut Logger for log into file </a>
12. <a href="https://github.com/bumptech/glide">Glide </a>
13. <a href="https://developer.android.com/topic/libraries/architecture/paging/v3-overview">Paging 3 </a>
14. <a href="https://site.mockito.org/">Mockito </a>
15. <a href="https://ktlint.github.io/">Ktlint </a>
16. <a href="https://detekt.dev/">Detekt </a>

For loading cats photos: <a href="https:://thecatapi.com">CATS API</a>
<br>You can obtain your own API_KEY

To set up ApiKey you can do next steps.

1. Create in projects root folder file "apikey.properties";
2. Add variables:
   <br>BASE_URL = "https://api.thecatapi.com/v1/images/";
   <br>CATS_API_KEY = "your_api_key";
3. Build the project;
4. In code you can find this properties using: BuildConfig.BASE_URL or BuildConfig.CATS_API_KEY.
