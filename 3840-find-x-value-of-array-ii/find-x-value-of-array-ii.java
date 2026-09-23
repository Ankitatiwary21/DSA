class Solution {

    class Node {
        int prod;
        int[] cnt;

        Node(int k) {
            prod = 1;
            cnt = new int[k];
        }
    }

    class SegmentTree {
        int n;
        int k;
        int[] nums;
        Node[] tree;

        SegmentTree(int[] nums, int k) {
            this.n = nums.length;
            this.k = k;
            this.nums = nums;
            this.tree = new Node[4 * n];

            build(1, 0, n - 1);
        }

        void build(int node, int l, int r) {
            if (l == r) {
                tree[node] = new Node(k);

                int rem = nums[l] % k;

                tree[node].prod = rem;
                tree[node].cnt[rem] = 1;

                return;
            }

            int mid = l + (r - l) / 2;

            build(node * 2, l, mid);
            build(node * 2 + 1, mid + 1, r);

            tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
        }

        Node merge(Node left, Node right) {
            Node res = new Node(k);

            // Product of the complete segment
            res.prod = (int) ((long) left.prod * right.prod % k);

            // Prefixes completely inside the left segment
            for (int rem = 0; rem < k; rem++) {
                res.cnt[rem] += left.cnt[rem];
            }

            // Prefixes that contain the complete left segment
            // and then a prefix of the right segment
            for (int r = 0; r < k; r++) {
                int newRem = (int) ((long) left.prod * r % k);

                res.cnt[newRem] += right.cnt[r];
            }

            return res;
        }

        void update(int index, int value) {
            update(1, 0, n - 1, index, value);
        }

        void update(int node, int l, int r, int index, int value) {
            if (l == r) {
                tree[node] = new Node(k);

                int rem = value % k;

                tree[node].prod = rem;
                tree[node].cnt[rem] = 1;

                return;
            }

            int mid = l + (r - l) / 2;

            if (index <= mid) {
                update(node * 2, l, mid, index, value);
            } else {
                update(node * 2 + 1, mid + 1, r, index, value);
            }

            tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
        }

        Node query(int ql, int qr) {
            return query(1, 0, n - 1, ql, qr);
        }

        Node query(int node, int l, int r, int ql, int qr) {

            if (ql <= l && r <= qr) {
                return tree[node];
            }

            int mid = l + (r - l) / 2;

            if (qr <= mid) {
                return query(node * 2, l, mid, ql, qr);
            }

            if (ql > mid) {
                return query(node * 2 + 1, mid + 1, r, ql, qr);
            }

            Node left = query(node * 2, l, mid, ql, qr);
            Node right = query(node * 2 + 1, mid + 1, r, ql, qr);

            return merge(left, right);
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        int n = nums.length;

        SegmentTree segTree = new SegmentTree(nums, k);

        int[] result = new int[queries.length];

        for (int idx = 0; idx < queries.length; idx++) {

            int index = queries[idx][0];
            int value = queries[idx][1];
            int start = queries[idx][2];
            int x = queries[idx][3];

            // Persistent update
            segTree.update(index, value);

            // Query nums[start ... n-1]
            Node node = segTree.query(start, n - 1);

            // Number of valid prefixes whose product % k == x
            result[idx] = node.cnt[x];
        }

        return result;
    }
}