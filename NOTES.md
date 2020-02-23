# Notes

Wanted to create an extendable design , where it would be easier to add more offers in future without 
disturbing existing code , following OpenClosed design principle.

Even though in the current design we are iterating through the items again and again for each new offer
it would still be better, as the user's basket would not have too many items (few hundred at max) and but following 
this design makes the code much easier to read and extend.

What could have been done with more time

- Offers could possibly be divided into two categories : unit and weight
- instead of creating new Offer class for each new offer , some offer could be more generic , so they can be re-used for new offers
- we could perhaps do better encapsulation of the code, as not all the class and methods needs to be public
  - also we don't need to keep all classes in the same package
- could use spring dependency injection , for example in Basket for adding offer-service
- exception handling could be looked at in more detail
- logging could be improved
- We are only using a single Enum to define product-names , this will become very huge , we should consider adding further categorization of products , 
  - like Milk could be a category of a product , with parameters like type : skimmed , semi-skimmer , full-fat , Brands
- catalogue a list of all possible offers, and try to add a few different ones in this design. And see what could be improved
  - example , offers could live in database , which would make it easier for a business (non-technical) person to add / amend an offer, that too without a release.
- unit testing could be extended
  - example : BasketTest should include test to ensure offer-service is being called