function solution(clothes) {
  let map = new Map();
  clothes.forEach((v) => {
    if (!map.has(v[1])) map.set(v[1], 0);
    map.set(v[1], map.get(v[1]) + 1);
  });
  let answer = 1;
  for (let [k, v] of map) {
    answer *= v + 1;
  }
  return answer - 1;
}
