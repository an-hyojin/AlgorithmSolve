function solution(genres, plays) {
    let answer = [];
    const genresMap = new Map();
    for(let i=0;i < genres.length; i++){
        if(!genresMap.has(genres[i]))genresMap.set(genres[i], []);
        genresMap.get(genres[i]).push({no: i, playNum: plays[i]});
        
    }
    
    const counts = []
    for(let [k,v] of genresMap){
        const sum = v.reduce((prev,next) => prev+next.playNum,0);
        counts.push({genre:k, sum});
    }
    
    counts.sort((a, b)=>b.sum-a.sum);
    counts.forEach(v => {
        let genreList = genresMap.get(v.genre);
        genreList.sort((a, b) => b.playNum - a.playNum)
        answer.push(...genreList.slice(0,2).map(v => v.no));
    });
    
    return answer;
}