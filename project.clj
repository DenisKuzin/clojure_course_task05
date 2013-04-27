(defproject clojure_course_task05 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [me.raynes/laser "1.1.1"]
                 [enfocus "1.0.1"]
                 [jayq "2.3.0"]
                 [korma "0.3.0-RC5"]
                 [mysql/mysql-connector-java "5.1.24"]
                 [criterium "0.4.1"]]
  :plugins [[lein-ring "0.8.2"]
            [lein-cljsbuild "0.3.0"]]
  :ring {:handler clojure_course_task05.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}}
  :aot []
  :source-paths ["src/clj" "src/cljs"]
  :cljsbuild
  {:builds
   [
    {:source-paths ["src/cljs"],
     :id "main",
     :compiler
     {:pretty-print true,
      :output-to "resources/public/js/main.js",
      :warnings true,
      :externs ["externs/jquery-1.9.js"],
      :optimizations :whitespace,
      :print-input-delimiter false}}]}
  :war {:name "ROOT.war"})
