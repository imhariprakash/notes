# Computer:
- powerful, mass data, speed, runs the algorithm
- not creative, insightful about problem

# Hardware:

# Software:
- code: pieces of instructions

# colors:
- pixel: smallest fundamental unit for the representation of colors
- RGB: color coding representation used in computers (normally)
  - R: Red, G: Green, B: Blue
  - 2^8 * 2^8 * 2^8 = 17.6 million combinations
  - (0,0,0): black, (255,255,255): white
- Greyscale
  - when all the R, G, and B have the same intensity (the lower the intensity, the darker the greyscale image)
  - 0,0,0 -> pure black, (255,255,255) -> pure white
  - (50,50,50): dark grey, (120,120,120): medium grey, (200,200,200): lighter grey
- Regular to greyscale image
  - Take the average of R, G, and B : (R + G + B) / 3
  - assign it to all the R, G, and B
- Is reddish
  - when R > 150 (some threshold) - doesn't mean red
  - (255,255,255): means whitish not reddish
  - find: take average
    - when red is way more than the average, only reddish (1.1 times, 1.5 times,...)
- Blue screen effect:
  - record in a blue screen or green screen -> replace the actual image with the background image
  - Algorithm:
    - detect red pixels
    - for each (x,y) pixel in the image target, replace the corresponding pixel in the background image
    - maintain adjacent pixels
  - Python:
    ```python
    from simpleimage import SimpleImage
    front_image = SimpleImage("skop.png")
    back_image = SimpleImage("back.png")

    for pixel in front_image:
      avg = (pixel.red + pixel.green + pixel.blue) / 3
      if pixel.green > 1.5 * avg:
        x = pixel.x
        y = pixel.y
        back_pixel = back_image.get_pixel(x, y)
        pixel.red = back_pixel.red
        pixel.green = back_pixel.green
        pixel.blue = back_pixel.blue

    front_image.show()
 
<img src="https://github.com/imhariprakash/notes/blob/main/CS%20105%20-%20Stanford%20Introduction%20to%20computer%20science/assets/bluescreeneffect.png" alt="Blue screen effect" width="1500" height="300">
