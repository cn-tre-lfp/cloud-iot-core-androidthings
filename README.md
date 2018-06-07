# IoT Core Client for Android Things

The IoT Core Client makes it easy to integrate Android Things with Google Cloud IoT Core by
providing abstractions for all of Cloud IoT Core's
[device functions](https://cloud.google.com/iot/docs/concepts/devices), publishing telemetry
events, publishing device state, and receiving device configuration from Cloud IoT Core.

The library handles all concurrency so clients can use it in the main thread. It also manages
interactions with the Cloud IoT Core
[MQTT bridge](https://cloud.google.com/iot/docs/how-tos/mqtt-bridge) so users don't have to worry
about low-level networking protocols.

## Getting started

There are three steps to using this library: set up Cloud IoT Core, download the library, and then,
start using the library to communicate with Cloud IoT Core.

### Set up Cloud IoT Core

Follow the instructions on the Cloud IoT Core website to
[enable the Cloud IoT Core API](https://cloud.google.com/iot/docs/how-tos/getting-started),
[create a device registry](https://cloud.google.com/iot/docs/how-tos/devices#creating_a_device_registry),
and
[register your device](https://cloud.google.com/iot/docs/how-tos/devices#creating_device_key_pairs).

### Add the library as a dependency

Add the following lines to your app's build.gradle:

```groovy
dependencies {
    implementation 'com.google.android.things:cloud-iot-core:1.0.0'
}
```

### Communicate with Cloud IoT Core

Once Cloud IoT Core is configured, getting your device connected only takes a few lines of code:

```java
// Load the keys used to register this device
KeyPair keys =  ...

// Configure Cloud IoT Core project information
ConnectionParams connectionParams = new ConnectionParams.Builder()
    .setProjectId("<your Google Cloud project ID>")
    .setRegistry("<your Cloud IoT Core registry ID>", "<your registry's cloud region>")
    .setDeviceId("<this device's ID in the registry>")
    .build();

// Initialize the IoT Core client
IotCoreClient client = new IotCoreClient.Builder()
    .setConnectionParams(connectionParams)
    .setKeyPair(keys)
    .build();

// Connect to Cloud IoT Core
client.connect();

// Start sending data!
client.publishDeviceState("Hello world!\n".getBytes());
```

The full documentation is available at **TODO(blaws): link to javadocs**

## Learn more

* [Android Things](https://developer.android.com/things/)
* [Google Cloud IoT Core](https://cloud.google.com/iot-core/)

## License

Copyright 2018 Google LLC

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.