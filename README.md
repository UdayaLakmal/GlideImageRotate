# GlideImageRotate
## Android Rotate and Mirror for Glide set images as a Bitmap.
Basic example implemantation of get image as a Bitmap via Glide (that we can save to a file or upload later) and rotate that Bitmap 90, 180 or 270 degrees and even mirrored.
used  [Glide 4.8.0](https://github.com/bumptech/glide).
## Demo
![](https://media.giphy.com/media/2ce3UmzmWh3woCxMQ1/giphy.gif)

## Code
To get Glide image to Bitmap file
```java
private Bitmap theBitmap;
private ImageView iv;
```

```java

Glide
                .with(getApplicationContext()).asBitmap()
                .load("https://source.unsplash.com/500x500/daily/?car")
                .into(new SimpleTarget<Bitmap>() {

                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        theBitmap =resource;
                        iv.setImageBitmap(theBitmap);
                    }
                });
```

To rotate Bitmap

```java
    public Bitmap RotateBitmap(Bitmap source, float angle)
    {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }

```
To flip

This will mirror vertically, if need horizontal flip use as ```m.preScale(1, -1);``` 


```java
    public Bitmap flip(Bitmap source)
    {
        Matrix m = new Matrix();
        m.preScale(-1, 1);
       return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), m, false);
    }
```



