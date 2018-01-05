module.exports = function (grunt) {

    grunt.initConfig({

        pkg: grunt.file.readJSON('package.json'),

        folders: {
            node_modules: 'node_modules/',
            webapp: {
                root: 'src/main/webapp/resources/',
                lib: 'src/main/webapp/lib/',
                build: 'src/main/webapp/WEB-INF/'
            }
        },

        banner: '/*!\n * <%= pkg.title || pkg.name %> - v<%= pkg.version %> - ' +
        '<%= grunt.template.today("yyyy-mm-dd") %>\n' +
        '<%= pkg.homepage ? " * " + pkg.homepage + "\\n" : "" %>' +
        ' * Copyright (c) <%= grunt.template.today("yyyy") %> <%= pkg.author.name %>;' +
        ' Licensed <%= _.pluck(pkg.licenses, "type").join(", ") %>\n*/\n',

        copy: {
            resources: {
                files: [
                    {
                        expand: true,
                        cwd: 'node_modules/',
                        src: ['angular/**'],
                        dest: 'src/main/webapp/lib/'
                    },
                    {
                        expand: true,
                        cwd: 'node_modules/',
                        src: ['angular-animate/**'],
                        dest: 'src/main/webapp/lib/'
                    },
                    {
                        expand: true,
                        cwd: 'node_modules/',
                        src: ['angular-cookies/**'],
                        dest: 'src/main/webapp/lib/'
                    },
                    {
                        expand: true,
                        cwd: 'node_modules/',
                        src: ['angular-resource/**'],
                        dest: 'src/main/webapp/lib/'
                    },
                    {
                        expand: true,
                        cwd: 'node_modules/',
                        src: ['angular-route/**'],
                        dest: 'src/main/webapp/lib/'
                    },
                    {
                        expand: true,
                        cwd: 'node_modules/',
                        src: ['angular-sanitize/**'],
                        dest: 'src/main/webapp/lib/'
                    },
                    {
                        expand: true,
                        cwd: 'node_modules/',
                        src: ['components-font-awesome/**'],
                        dest: 'src/main/webapp/lib/'
                    },
                    {
                        expand: true,
                        cwd: 'node_modules/',
                        src: ['lodash/**'],
                        dest: 'src/main/webapp/lib/'
                    },
                    {
                        expand: true,
                        cwd: 'node_modules/',
                        src: ['jquery/**'],
                        dest: 'src/main/webapp/lib/'
                    },
                    {
                        expand: true,
                        cwd: 'node_modules/',
                        src: ['angular-route/**'],
                        dest: 'src/main/webapp/lib/'
                    },
                    {
                        expand: true,
                        cwd: 'node_modules/',
                        src: ['angular-ui-bootstrap/**'],
                        dest: 'src/main/webapp/lib/'
                    }

                ]
            }
        },

        serve: {
            options: {
                port: 9000
            }
        },

        jshint: {
            options: {
                curly: false,
                eqeqeq: true,
                immed: true,
                latedef: false,
                newcap: true,
                noarg: true,
                sub: true,
                undef: false,
                unused: true,
                boss: true,
                eqnull: true,
                browser: true,
                globals: {
                    jQuery: true
                },
                reporterOutput: ''
            },
            all: ['Gruntfile.js', '<%= folders.webapp.root %>/app/**/*.js']
        },

        qunit: {
            files: ['test/**/*.html']
        },

        watch: {
            js: {
                files: '<%= jshint.all %>',
                tasks: ['concat:js']
            },
            templates: {
                files: ['<%= folders.webapp.root %>/index.html', '<%= folders.webapp.root %>templates/**/*.html'],
                tasks: ['copy:templates']
            },
            css: {
                files: '<%= folders.webapp.root %>/style/*.css',
                tasks: ['concat:css']
            }

        }
    });

    // Load grunt tasks
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-qunit');
    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-htmlcompressor');
    grunt.loadNpmTasks('grunt-serve');

    // Register new tasks
    grunt.registerTask('build', ['copy']);
    grunt.registerTask('minimise', ['copy', 'concat', 'uglify', 'htmlcompressor']);
    grunt.registerTask('dev', ['jshint', 'concat']);
    grunt.registerTask('serve', ['serve', 'watch']);

};
