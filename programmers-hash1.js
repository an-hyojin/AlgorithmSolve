function solution(participant, completion) {
  let answer = "";
  let participants = new Map();
  participant.forEach((v) => {
    if (!participants.has(v)) participants.set(v, 0);
    participants.set(v, participants.get(v) + 1);
  });
  completion.forEach((v) => {
    let remain = participants.get(v);
    if (remain === 1) participants.delete(v);
    else participants.set(v, remain - 1);
  });
  for (let [key] of participants) {
    answer = key;
  }
  return answer;
}
