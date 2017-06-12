package grails.ssc.mongodb

import demo.Book
import demo.Role
import demo.User
import demo.UserRole

class BootStrap {

    def init = { servletContext ->
        Book.withTransaction {
            if ( !Book.findByName('The definitive Grails Guide') ) {
                Book.saveAll(
                        new Book(name: 'The definitive Grails Guide')
                )
            }

        }
        User.withTransaction {
            if ( !User.findByUsername('sherlock') ) {
                def detective = new Role(authority: 'ROLE_DETECTIVE')
                detective.save()

                def sherlock = new User(username: 'sherlock', password: 'elementary')
                sherlock.save()

                def sherlockIsADetective = new UserRole(user: sherlock, role: detective)
                sherlockIsADetective.save()
            }

        }
    }
    def destroy = {
    }
}
