/**
 * @param {number[]} servers
 * @param {number[]} tasks
 * @return {number[]}
 */
var assignTasks = function(servers, tasks) {
    const order = (a, b) => a[0] - b[0] || a[1] - b[1] || a[2] - b[2];  // [second it frees up, weight, index]
    const free = new PriorityQueue(order, servers.map((w, i) => [0, w, i]));  // 0 while free: by weight, then index

    const ans = [], busy = new PriorityQueue(order);
    for (const [s, t] of tasks.entries()) {
        while (!busy.isEmpty() && busy.front()[0] <= s) {  // done by second s
            const [, w, i] = busy.dequeue();
            free.enqueue([0, w, i]);
        }
        const [at, w, i] = (free.isEmpty() ? busy : free).dequeue();  // none free: the first to finish takes it
        busy.enqueue([Math.max(at, s) + t, w, i]);
        ans.push(i);
    }

    return ans;
};