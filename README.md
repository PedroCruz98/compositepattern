# Composite Pattern

## What is it?

In summary, the pattern describes a group of objects that are treated the same way a single object would be
(For more info [click here](https://en.wikipedia.org/wiki/Composite_pattern)).

## How can you use it?

To exemplify the usage of such a pattern, we first needed a practical example on where to use it.

With that being said, the software to be developed as an example should be a grade calculation simulation system.
That is, it should replicate the process through which oneself calculates its final grade.

The following class structure was developed:

![Class Diagram](https://www.planttext.com/api/plantuml/img/ZP3D2i8m3CVlVOeSzU0JA38GVG4VG48RNR5jHffDGNntkmrreWTpo__Z5qYL5KNR68p9PvyQ58mGER6jXIE1IajJAzVe-EBJQRLAV1YtzNgC_KnTlDRlt153BZoVbEI8bc3ROMXHFIUu6IYpLoazS9Ij-AOtPlFbuEm2eq93OYafdkXJxpc3T3V61imPzeKJQ7B0noPGBENyUVRLs72VkFvH0NHkHXsEmjo0KEIEUYayjOBz1l9YCI4PKr5ovViF)

**Evaluation Interface**
- Each evaluation has a description (so it can be identifiable), a weight (percent wise), and a value (grade given to that component).

**SingleEvaluation**
- Has a grade defined in a float variable (since it represents a leaf node in the composite pattern).

**ComplexEvaluation**
- Has a list of _evaluations_, and it calculates its final value according to the _evaluations'_ values.
