function removeWords(sentence) {
  const words = Array.from(
    new Array(sentence.length),
    () => new Array(sentence.length)
  );
  const res = dynamicProgramming(words, 0, sentence.length - 1, sentence);
  console.log(res);
}

function dynamicProgramming(words, start, end, sentence) {
  if (!!words[start][end]) return words[start][end];
  if (start >= end) {
    return 0;
  } else if (sentence[start] === sentence[end]) {
    return dynamicProgramming(words, start + 1, end - 1, sentence);
  } else {
    const removeFirst = dynamicProgramming(words, start + 1, end, sentence) + 1;
    const removeEnd = dynamicProgramming(words, start, end - 1, sentence) + 1;
    words[start][end] = Math.min(removeFirst, removeEnd);
    return words[start][end];
  }
}
