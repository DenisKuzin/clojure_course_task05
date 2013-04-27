(ns clojure_course_task05.main
  (:require [enfocus.core :as ef]
  [clojure_course_task05.util :as util])
  (:require-macros [enfocus.macros :as em])
  (:use [jayq.core :only [$ css inner document-ready]]))

(defn show-add-modal []
      (.modal ($ "#AddProblemModal")))

(defn hide-add-modal []
      (.modal ($ "#AddProblemModal") "hide"))

(defn select-problem [name]
      (.val ($ "#inputProblem") name))

(defn try-add-problem []
  (let [problem (util/get-element-value :#inputProblemModal)
        description (util/get-element-value :#inputDescriptionModal)]
    (util/post-data "/timeit-add-problem"
                    hide-add-modal
                    {:name problem, :description description})))

(document-ready (fn [] 
		(.click ($ "#ShowAddModal") show-add-modal)))

(em/defaction add-to-select [name]
  ["#inputProblem"] (em/prepend (str "<option>" name "</option>")))

(em/defaction setup []
  ["#AjaxAddProblem"] (em/listen :click #(add-to-select (.val ($ "#inputProblemModal"))))
  ["#AjaxAddProblem"] (em/listen :click #(select-problem (.val ($ "#inputProblemModal"))))
  ["#AjaxAddProblem"] (em/listen :click #(try-add-problem)))
;  ["#AjaxAddProblem"] (em/listen :click #(hide-add-modal)))

(set! (.-onload js/window) setup)