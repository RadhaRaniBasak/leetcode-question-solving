# Minimum Cost to Acquire Required Items

## Approach: Combo Meal Analogy

Imagine a fast-food counter where we need `need1` burgers and `need2` orders of fries.

1. A `burger` alone costs `cost1`.
2. An order of `fries` alone costs `cost2`.
3. A `combo` with one of each costs `costBoth`.

Extra food is fine, so we can buy a `combo` even when we only need the burger inside it:

- which is exactly what "at least `need1`" and "at least `need2`" mean in the problem.

## Algorithm

### Pairs
- We need a burger and fries together `min(need1, need2)` times, so we call each of these a `pair`.
- For each `pair`, we pick the cheaper of one `combo` or a burger plus fries:
  - `min(costBoth, cost1 + cost2)`

### Leftovers
After pairing, only one side can have anything left, since either `need1 - pairs` or `need2 - pairs` is `0`.

Thus, each leftover item is either bought alone, or taken out of a `combo` while the other half is tossed:

- Each leftover burger costs `min(cost1, costBoth)`.
- Each leftover order of fries costs `min(cost2, costBoth)`.

In Example 1, a `combo` costs `1` and a burger costs `3`, so even the leftover burger comes from a `combo`: `3` combos for a total of `3`.

## Complexity
- Time complexity: `O(1)`
- Space complexity: `O(1)`

## Code
`need1` and `need2` go up to `10^9` and the costs up to `10^6`, so the total can reach `10^15`. That's why everything is converted to `long` first.

```java
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1, c2 = cost2, cb = costBoth;
        long n1 = need1, n2 = need2;

        long pairs = Math.min(n1, n2);
        long costPairs = pairs * Math.min(cb, c1 + c2);

        long rem1 = n1 - pairs;
        long rem2 = n2 - pairs;
        long costRem = rem1 * Math.min(c1, cb) + rem2 * Math.min(c2, cb);

        return costPairs + costRem;
    }
}
```
