Design
======

SearchContext
- Parent search context
- Step score
- Total score (step score + parent total score)

Create a list of search contexts, remove half that are below the threashold.
Create a new list from the remaining tree nodes, set each new context as being a child for scoring.
Remove half that are below threshold repeat.

Keep track of final words found with the score at that point
