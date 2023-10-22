import '@/styles/globals.css'
import type {AppProps} from 'next/app'
import Layout from '@/pages/components/Layout'

export default function App({Component, pageProps}: AppProps) {
    return (Component && Component.name) === 'Login' ||
    (Component && Component.name) === 'SignUp' ?
        (
            <Component {...pageProps} />
        ) : (
            <Layout>
                <Component {...pageProps} />
            </Layout>
        )
}
