# Andrew's Katas

## Three laws of TDD

Uncle Bob describes TDD with three rules:

1. You are not allowed to write any production code unless it is to make a failing unit test pass.
2. You are not allowed to write any more of a unit test than is sufficient to fail; and compilation failures are failures.
3. You are not allowed to write any more production code than is sufficient to pass the one failing unit test.

Read them carefully and you'll notice they're simpler than they look like, but they have a lot of repetition so here's a "refactored" version:

1. Write production code only to make a failing unit test pass.
2. Write only enough of a unit test to fail.
3. Write only enough production code to make the failing unit test pass.

It's obvious now that rule 3 implies rule 1, so here's a concise version that I've found easier to remember:

1. Write only enough of a unit test to fail.
2. Write only enough production code to make the failing unit test pass.

This couple of rules also serve me as a checklist when I'm developing, so I just repeat them in order, over and over, to keep me in the TDD loop.