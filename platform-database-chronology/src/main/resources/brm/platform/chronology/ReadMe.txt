The chronology module is used to define aspects of a game's time-keeping functions; it is meant to handle both a clock
and a calendar. A clock handles the particular time-of-day, in the day/night cycle, if part of the game. A calendar, on
the other hand, handles the advancement of time beyond a single day.

The clock data includes the following:
- second: often not displayable, because at game time-scale, would zip by too fast; but still used in time-tracking.
- minute: the common time increment that will be displayed;
- hour  : .

The calendar data includes the following:
- day
- weekday
- month
- year

This platform-database-chronology module should contain the values for the game's beginning and ending dates and times, as well
as how many of each time-parts are in each larger time-part.

In conclusion, the game seconds may advance at a different increment based upon party location; when on the overworld
map, the number of seconds may advance quite fast, due to the apparent "scale" of a tile, and when in town, the number
of seconds might advance a quarter to an eighth as fast.