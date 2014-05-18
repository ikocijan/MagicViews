MagicViews
==========

Provides a simple way to set custom font in Android applications.




## Usage

Add the library as a dependency to your ```build.gradle```

```groovy
debugCompile 'com.ivankocijan.magicviews'
```

Add typface to your assets folder and instead of TextView use com.ivankocijan.magicviews.views.MagicTextView.

```xml
    <com.ivankocijan.magicviews.views.MagicTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:typeFace="cha_chicle.otf"/>
```

## Suported views
* TextView

#### Version 1.0
* Added support for TextView


## Contributing

Feedback and code contributions are very much welcome. Just make a pull request with a short description of your changes. By making contributions to this project you give permission for your code to be used under the same [license](LICENSE).
    
