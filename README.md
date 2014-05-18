MagicViews
==========

Provides a simple way to set custom font in Android application.

![Screenshots](https://raw.github.com/ikocijan/MagicViews/master/screenshot.png)

## Usage

Add the library as a dependency to your ```build.gradle```

```groovy
debugCompile 'com.ivankocijan.magicviews'
```

Add typeface to your assets folder and instead of TextView use <code>com.ivankocijan.magicviews.views.MagicTextView</code>

```xml
    <com.ivankocijan.magicviews.views.MagicTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:typeFace="cha_chicle.otf"/>
```

You can add your font anywhere in assets folder. Check TestApp for example.

## Suported views
* TextView

## Contributing

Feedback and code contributions are very much welcome. Just make a pull request with a short description of your changes. By making contributions to this project you give permission for your code to be used under the same [license](LICENSE).
    
