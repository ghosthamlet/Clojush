(ns default
  (:require
   [clojure.contrib.seq-utils :as seq-utils]
   [clojure.test]
   [clojush])
  (:use [clojure.test]))

;; All unimplemented tests have the stub (is 0 0)

(def test-tree '((0 1)(1 (1 1)) 0))

;; function unit tests

;;subst #'clojush/subst
(deftest subst-test
  (let [lst1 '((0 1)(1 (1 1)) 0) lst2 '() this 2 that 0]
    (is (seq-utils/find-first #(= % this) (clojush/subst this that lst1)) this)
    (is (not (seq-utils/find-first #(= % this) (clojush/subst this that lst2))) true)))

;; ;;discrepancy #'clojush/discrepancy
(deftest discrepancy-test
  (is (clojush/discrepancy test-tree test-tree) 0)
  (is (clojush/discrepancy test-tree '()) 2)
  (is (clojush/discrepancy '() '()) 0))

;; ;;tagged-code-macro-erc #'clojush/tagged-code-macro-erc
(deftest tagged-code-macro-erc
  (is 0 0))

;; ensure-list #'clojush/ensure-list
(deftest ensure-list-test
  (is (clojush/ensure-list '()) list?)
  (is (clojush/ensure-list []) list?)
  (is (clojush/ensure-list 1) list?))

;;truncate #'clojush/truncate
(deftest truncate-test
  (is (clojush/truncate 1) 1)
  (is (clojush/truncate 1.3) 1))

;; evaluate-individual #'clojush/evaluate-individual
(deftest evaluate-individual-test
  (is (clojush/evaluate-individual {:program 'TEST :errors '(1) :total-error '(1) :history '(1) :ancestors 'TEST-MAMA}
				   (fn [x] 2)
				   (java.util.Random.))
      {:program 'TEST :errors '(1) :total-error 1 :history (cons 1 '(1)) :ancestors 'TEST-MAMA})
  (is (clojush/evaluate-individual {:program 'TEST :errors 1 :total-error 1 :history '(1) :ancestors 'TEST-MAMA}
				   (fn [x] 2)
				   (java.util.Random.))
      {:program 'TEST :errors 2 :total-error 1 :history '(1) :ancestors 'TEST-MAMA}))

;;codemaker #'clojush/codemaker
(deftest codemaker-test
  (is (apply (clojush/codemaker :float) (list {:float '(1.0) :code '()}))
      {:float '() :code '(1.0)})
  (is (apply (clojush/codemaker :integer) (list (clojush/make-push-state)))
      {:exec nil :integer nil :float nil :code '(1.0) :boolean nil :auxiliary nil :tag nil :zip nil}))

;;remove-code-at-point #'clojush/remove-code-at-point
(deftest remove-code-at-point-test
 (is (clojush/remove-code-at-point test-tree 0) (rest test-tree))
 (is (clojush/remove-code-at-point test-tree 10) test-tree))

;;breed #'clojush/breed

;;, global-evalpush-limit #'clojush/global-evalpush-limit, global-reuse-errors #'clojush/global-reuse-errors, gaussian-noise-factor #'clojush/gaussian-noise-factor, stack-ref #'clojush/stack-ref, default-problem-specific-report #'clojush/default-problem-specific-report, instruction-table #'clojush/instruction-table, modder #'clojush/modder, tag-limit #'clojush/tag-limit, print-params #'clojush/print-params, select #'clojush/select, max-random-float #'clojush/max-random-float, decompose #'clojush/decompose, maintain-histories #'clojush/maintain-histories, perturb-with-gaussian-noise #'clojush/perturb-with-gaussian-noise, recognize-literal #'clojush/recognize-literal, min-number-magnitude #'clojush/min-number-magnitude, divider #'clojush/divider, tagged-code-macro? #'clojush/tagged-code-macro?, popper #'clojush/popper, subtracter #'clojush/subtracter, multiplier #'clojush/multiplier, untag-instruction-erc #'clojush/untag-instruction-erc, eval-push #'clojush/eval-push, decimate #'clojush/decimate, swapper #'clojush/swapper, perturb-code-with-gaussian-noise #'clojush/perturb-code-with-gaussian-noise, overlap-demo #'clojush/overlap-demo, all-items #'clojush/all-items, registered-for-type #'clojush/registered-for-type, not-lazy #'clojush/not-lazy, shover #'clojush/shover, crossover #'clojush/crossover, print-ancestors-of-solution #'clojush/print-ancestors-of-solution, insert-code-at-point #'clojush/insert-code-at-point, stackdepther #'clojush/stackdepther, zip-mover #'clojush/zip-mover, mutate #'clojush/mutate, lrand #'clojush/lrand, maxer #'clojush/maxer, ignore-errors #'clojush/ignore-errors, make-push-state #'clojush/make-push-state, choose-node-index-with-leaf-probability #'clojush/choose-node-index-with-leaf-probability, overlap #'clojush/overlap, debug-recent-instructions #'clojush/debug-recent-instructions, yankduper #'clojush/yankduper, registered-instructions #'clojush/registered-instructions, bin-string-to-int #'clojush/bin-string-to-int, handle-tag-code-macro #'clojush/handle-tag-code-macro, tag-instruction? #'clojush/tag-instruction?, registered-nonrandom #'clojush/registered-nonrandom, random-code-with-size #'clojush/random-code-with-size, zip-extractor #'clojush/zip-extractor, tagged-code-instruction-erc #'clojush/tagged-code-instruction-erc, pushgp-map #'clojush/pushgp-map, count-points #'clojush/count-points, stress-test #'clojush/stress-test, execute-instruction #'clojush/execute-instruction, handle-tag-instruction #'clojush/handle-tag-instruction, top-item #'clojush/top-item, tagged-instruction-erc #'clojush/tagged-instruction-erc, top-level-pop-code #'clojush/top-level-pop-code, ->individual #'clojush/->individual, random-code #'clojush/random-code, global-use-indirection #'clojush/global-use-indirection, closest-association #'clojush/closest-association, minner #'clojush/minner, adder #'clojush/adder, report #'clojush/report, global-evalpush-time-limit #'clojush/global-evalpush-time-limit, abbreviate-tagged-code-macros #'clojush/abbreviate-tagged-code-macros, greaterthaner #'clojush/greaterthaner, min-random-integer #'clojush/min-random-integer, global-pop-when-tagging #'clojush/global-pop-when-tagging, pop-item #'clojush/pop-item, choose-node-index-by-tournament #'clojush/choose-node-index-by-tournament, flusher #'clojush/flusher, -main #'clojush/-main, push-item #'clojush/push-item, map->individual #'clojush/map->individual, , contains-subtree #'clojush/contains-subtree, walklist #'clojush/walklist, keep-number-reasonable #'clojush/keep-number-reasonable, max-random-integer #'clojush/max-random-integer, auto-simplify #'clojush/auto-simplify, lessthaner #'clojush/lessthaner, maintain-ancestors #'clojush/maintain-ancestors, scaled-errors #'clojush/scaled-errors, global-agent-output #'clojush/global-agent-output, lrand-int #'clojush/lrand-int, eqer #'clojush/eqer, tag-instruction-erc #'clojush/tag-instruction-erc, global-max-points-in-program #'clojush/global-max-points-in-program, register-instruction #'clojush/register-instruction, top-level-push-code #'clojush/top-level-push-code, gaussian-mutate #'clojush/gaussian-mutate, make-individual #'clojush/make-individual, rand-signed-int-string #'clojush/rand-signed-int-string, yanker #'clojush/yanker, max-points-in-random-expressions #'clojush/max-points-in-random-expressions, zip-tester #'clojush/zip-tester, define-push-state-structure #'clojush/define-push-state-structure, duper #'clojush/duper, code-at-point #'clojush/code-at-point, min-random-float #'clojush/min-random-float, rotter #'clojush/rotter, pushgp #'clojush/pushgp, global-node-selection-tournament-size #'clojush/global-node-selection-tournament-size, postwalklist-replace #'clojush/postwalklist-replace, global-node-selection-method #'clojush/global-node-selection-method, define-registered #'clojush/define-registered, global-node-selection-leaf-probability #'clojush/global-node-selection-leaf-probability, max-number-magnitude #'clojush/max-number-magnitude, *thread-local-random-generator* #'clojush/*thread-local-random-generator*, run-push #'clojush/run-push, push-types #'clojush/push-types, postwalklist #'clojush/postwalklist, print-return #'clojush/print-return, push-state #'clojush/push-state, state-pretty-print #'clojush/state-pretty-print, global-atom-generators #'clojush/global-atom-generators, bt #'clojush/bt, zip-inserter #'clojush/zip-inserter, containing-subtree #'clojush/containing-subtree, select-node-index #'clojush/select-node-index}


(deftest clojush-stress-test
  (clojush/stress-test 10000))

(deftest run-push-test
  (is (clojush/run-push (clojush/random-code-with-size 5 '(integer_add integer_sub integer_mod integer_div integer_mult 1)) (clojush/make-push-state))))

;; (deftest report-test
;;   (clojush/report (vec (doall (map deref (vec (doall (for [_ (range 10)]
;; 						       (agent (clojush/make-individual :program (clojush/random-code-with-size 5 '(integer_add integer_sub integer_mod integer_div integer_mult 1))))))))))
;; 		  (clojush/lrand-int 10) (fn [x] 1) 0 clojush/default-problem-specific-report))

;; (deftest report-best-test
;;   (let [best (clojush/report (vec (doall (map deref (vec (doall (for [_ (range 10)]
;; 								  (agent (clojush/make-individual :program (clojush/random-code-with-size 5 '(integer_add integer_sub integer_mod integer_div integer_mult 1))))))))))
;; 			     (clojush/lrand-int 10) (fn [x] 1) 0 clojush/default-problem-specific-report)]
;;     (is (:total-error best 0) integer?)))
			    
;;(clojush/pushgp :error-function (fn [p] 0))
;; parallelization tests