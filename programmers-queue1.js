function solution(progresses, speeds) {
    const answer = [];
    let queue = progresses.slice();
    
    while(queue.length>0){
        const remainDay = Math.ceil((100-queue[0])/speeds[0]);
        queue = queue.map((v,index) => v +remainDay*speeds[index]);
        let prod = 0;
        while(queue.length>0&&queue[0]>=100){
            prod++;
            queue.shift();
            speeds.shift();
        }
        answer.push(prod);
    }
    return answer;
}