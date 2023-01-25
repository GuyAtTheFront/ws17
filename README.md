
# Workshop17

## models
* Ignore all annotations on in Models, unless you want to learn Jackson
* The model structure is more complicated than necessary because I was testing Jackson


## WeatherService.java
* The default application uses `.unpackJsonWithJsonObject` method to unmarshell the json data into POJO using JSON-P, quite an irritating process ngl...
* There's another method called `.unpackJsonWithMapper` that does the same thing using Jackson. But you'll need to proper annotations on the models / DTOs
* For assessment, use Json-P unmarshelling - ignore Jackson / Mapper unless you're an adrenaline junkie


## TODOs
* Error Handling for unsupported countries


## Last Words
Pass-fail only - you'll be fine!
Owardio o7
--GuyAtTheFront