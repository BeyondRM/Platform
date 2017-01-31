Of the apparent map-entities which are characters, the following variations should exist:

  A baseline NPC.         Provide raw positioning, pathfinding, or other properties; most commonly "flavor-characters".

  A classed NPC.          Define a class and class-related properties.

  A classed NPC hero.     Define additional properties of a recruitable hero (what we think of RM's "Actors").

  A classed NPC party.    Define a party object: a leader and followers; used for a player's party, AND an NPC's party.

  A classed NPC special.  Define other special-use NPC or character; this may be for unique NPC-processing (innkeepers,
                          merchants, trainers, etc.).

The classes in this platform module should only contain fields for managing data that can or will change from their own
equals in the character-definitions packages show. This module is perhaps more akin to the module for the engine's type
of defining and maintaining a series of in-map entities, and not what the platform should be concerned with.

Should we, in our Project modules, be also defining other in-map entity types? For the plantable crops, perhaps; we may
need to define the seed and plant types as items, along with their expected growing seasons, days for maturity, whether
perennial, and other properties.