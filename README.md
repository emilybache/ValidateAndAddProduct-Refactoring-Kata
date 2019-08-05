ValidateAndAddProduct Refactoring Kata
=======================================

This refactoring kata mixes logic for both validating input data and creating a new product in the dabase. It might be valuable to separate these two into separate 'Phases' (see Martin Fowler's ['Split Phase' refactoring](https://refactoring.com/catalog/splitPhase.html)) Before you refactor it, you will want some better test cases. There is one test case to start you off - using an Approval Testing framework. See the [https://approvaltests.com](Approval Tests website).

The change you need to make
---------------------------

The reason for the refactoring is that you need to add a new type of product - Lip gloss. It should behave the same as the 'Lipstick' type with a small difference - if the price is greater than 10 it should be put in the 'Queen' range instead of the 'Professional' range. If the weight is over 20 then you should return an error.

The 'with_tests' branch
-----------------------

If you want to go straight for the refactoring, you can find a good set of tests in the 'with_tests' branch. They use a Combination Approvals approach.
