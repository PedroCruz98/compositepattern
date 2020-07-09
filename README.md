# Composite Pattern

## What is it?

In summary, the pattern describes a group of objects that are treated the same way a single object would be
(For more info [click here](https://en.wikipedia.org/wiki/Composite_pattern)).

## How can you use it?

To exemplify the usage of such a pattern, we first needed a practical example on where to use it.

With that being said, the software to be developed as an example should be a grade calculation simulation system.
That is, it should replicate the process through which oneself calculates its final grade.

The following class structure was developed:

![Class Diagram](https://www.planttext.com/api/plantuml/img/hP5BQiCm48RtSueXgwIGGDSD8L3Q2-G0Pf36jgYaCTBOAPJSFNASrkvZMUtqlpw1ZbafQHyyG7vpiQD40OD4CMsImAYfvwMLMx9oTh7PxwDKq-rmc69_fivEspbNayzbpqNbL9DXV1d8zwHE8du0bdFIL7feEPlakj5ORvvkpgiNKkmu6OvA3N_NnvsRT04mddB6Kzdnl02uq7aEfPn_OE_CQW65-smryxwa9f7bcVCiu-xxVu80oTer3pHLDu29WmmyIlvJAm-0tspPUgvrkthSxHvM2pp0aQCj7tq5)

**Evaluation Interface**
- Each evaluation has a description (so it can be identifiable), a weight (percent wise), and a value (grade given to that component).

**SingleEvaluation**
- Has a grade defined in a float variable (since it represents a leaf node in the composite pattern).

**ComplexEvaluation**
- Has a list of _evaluations_, and it calculates its final value according to the _evaluations'_ values.
