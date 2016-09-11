# Kindle-Library-List
Extract documents list from Amazon Kindle webpage and save into a `txt`, `xml` and `html` file.

## How to use:

1. [Download](https://github.com/jaroslawhartman/Kindle-Library-List/tree/master/bin) (or build) `KindleLibrary.jar`
2. Navigate to [Manage your content and devices](https://www.amazon.com/mn/dcw/myx.html/ref=nav_youraccount_myk) Amazon page
3. Switch Show to Docs
![Image 1](https://cloud.githubusercontent.com/assets/964833/18419183/9b19b5bc-7855-11e6-8676-bc986ac2f63b.png)
4. Scroll down to reach end of your list (or to see _Show more_ button)
![Image 2](https://cloud.githubusercontent.com/assets/964833/18419184/9b1e2f48-7855-11e6-9b14-09a98112d3a1.png)
5. Save the html (_File_ -> _Save Page As..._, using _Complete Webpage_). Override the default filename with an easy name, e.g. _1_.
6. If more docs pending, press _Show More_ button on the bottom of the page and iterate to _Step 4_
7. When all pages iterated, open a command line and invoke the conversion:

```
Jareks-MBP:Downloads jhartman$ java -jar KindleLibrary.jar 1.htm
Amazon book list extractor
Elements found:400
Saving 1.html
Saving 1.txt
Saving 1.xml
Done!
```

8.Convert all `html` files saved earlier

### Example of output `html` and `xml` looks as below

![Image 3](https://cloud.githubusercontent.com/assets/964833/18419185/9b215c68-7855-11e6-9250-89ec957a3177.png)
![Image 4](https://cloud.githubusercontent.com/assets/964833/18419186/9b27968c-7855-11e6-8192-783c715a9754.png)

## Libraries & References

* jsoup [Java HTML Parser](https://jsoup.org/)

jsoup is a Java library for working with real-world HTML. It provides a very convenient API for extracting and manipulating data, using the best of DOM, CSS, and jquery-like methods.