Libraries Used in template:

1. Navigation Component with NavArgs
2. Dagger 2
3. Kotlin Coroutines
4. Coroutines Lifecycle Scope
5. Fragments KTX
6. Room
7. Retrofit 2
8. Moshi
9. OkHTTP3 Interceptor
10. GSON
11. Orhanobut Logger for log into file
12. Glide
13. Paging 3
14. Mockito 
15. Ktlint
16. Detekt

For loading cats photos: thecatapi.com
You can obtain your own API_KEY

To set up ApiKey you can do next steps.

1. Create in projects root folder file "apikey.properties";
2. Add variables:
   BASE_URL = "https://api.thecatapi.com/v1/images/";
   CATS_API_KEY = "your_api_key";
3. Build the project;
4. In code you can find this properties using: BuildConfig.BASE_URL or BuildConfig.CATS_API_KEY.
