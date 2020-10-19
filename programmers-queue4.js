function solution(priorities, location) {
  let queueIndex = 0;

  const docs = priorities.map((v, i) => {
    return { prior: v, index: i };
  });
  let count = 0;
  while (docs.length > 0) {
    const recentPrior = docs[queueIndex].prior;
    let isPrint = true;
    for (let i = 1; i < docs.length; i++) {
      const compPrior = docs[(i + queueIndex) % docs.length].prior;
      if (recentPrior < compPrior) {
        queueIndex = (queueIndex + i) % docs.length;
        isPrint = false;
        break;
      }
    }
    if (isPrint) {
      const print = docs[queueIndex].index;
      count++;
      if (print === location) {
        return count;
      }
      docs.splice(queueIndex, 1);
      queueIndex = queueIndex % docs.length;
    }
  }
  return count;
}
