###Gilded Rose To Do List

#### Done
- Test GildedRose logic separately from the individual items logic
- Remove duplication on the creation of GildedRose in tests 
  - Done due to splitting the tests more thinly. Duplication is less prevalent but might reoccur as more features add up)
- SimpleItem logic should not be tested inside conjured item logic
- Improve encapsulation of items[0] in the gilded rose logic

#### TODO

- GildedRoseShop should not be stateful but rather a modified version of the GildedRoseShop should be returned every time.
- Improve test and mutation coverage
- Slight unknowns around Sulfuras
- Improve assertions using matchers
- Improve data creation

#### Further ideas from shop owner and shop customers 

- Any item can become Conjured
- New items can be added into the gilded rose shop
- Every day there is a 10% chance for items to contract fungi infections with all of them decreasing in quality twice as fast 
