li	$t0, 6
li	$t1, 2
li	$t2, 3
li	$t3, 4
li	$t4, 5
li	$t5, 3
mult	$t1, $t5
mflo	$t5
sub	$t5, $t0, $t5
move	$t1, $t5

li	$t5, 3
div	$t5, $t0
mflo	$t5
mult	$t5, $t1
mflo	$t5
li	$t6, 21
add	$t5, $t5, $t6
li	$t6, 2
mult	$t0, $t6
mflo	$t6
sub	$t5, $t5, $t6
move	$t6, $t5

li	$t5, 5
mult	$t6, $t5
mflo	$t5
li	$t7, 6
div	$t0, $t7
mflo	$t7
mult	$t7, $t2
mflo	$t7
add	$t5, $t5, $t7
li	$t7, 6
add	$t5, $t5, $t7
move	$t7, $t5

move	$a0, $t6
li	$v0, 1
syscall
move	$a0, $t7
li	$v0, 1
syscall
move	$a0, 5
li	$v0, 1
syscall
